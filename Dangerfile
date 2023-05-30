# Android Lintの実行結果を取得するタスク
lint_result = `./gradlew lintDebug --console plain --quiet`

if lint_result.include?("Lint found errors")
    fail("Android Lint errors detected:")
    markdown(lint_result)
elsif lint_result.include?("Lint found warnings")
    warn("Android Lint warnings detected:")
    markdown(lint_result)
else
    message("Android Lint check passed")
end
