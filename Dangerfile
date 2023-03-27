# Sometimes it's a README fix, or something like that - which isn't relevant for
# including in a project's CHANGELOG for example
declared_trivial = github.pr_title.include? "#trivial"

# Make it more obvious that a PR is a work in progress and shouldn't be merged yet
warn("PR is classed as Work in Progress") if github.pr_title.include? "[WIP]"

# Warn when there is a big PR
warn("Big PR") if git.lines_of_code > 500

# Don't let testing shortcuts get into master by accident
fail("fdescribe left in tests") if `grep -r fdescribe specs/ `.length > 1
fail("fit left in tests") if `grep -r fit specs/ `.length > 1

# Android Lintの結果ファイルの解析とコメント
Dir.glob("**/build/reports/lint-results*.html").each { |report|
    android_lint.skip_gradle_task = true # すでにある結果ファイルを利用する
    android_lint.report_file = report.to_s
    android_lint.filtering = false # エラーは追加・変更したファイルでなくてもコメント
    android_lint.lint(inline_mode: true) # コードにインラインでコメントする
}