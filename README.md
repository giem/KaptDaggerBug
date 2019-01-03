This project demonstrates how to reproduce the following error:
```
e: error: compiler message file broken: key=compiler.err.Processor: org.jetbrains.kotlin.kapt3.base.ProcessorWrapper@73a88df arguments={0}, {1}, {2}, {3}, {4}, {5}, {6}, {7}
e: error: cannot access Flowable
  class file for io.reactivex.Flowable not found
  Consult the following stack trace for details.
  com.sun.tools.javac.code.Symbol$CompletionFailure: class file for io.reactivex.Flowable not found
```

To fix the build you can do one of the following things:
1. Go to the `build.gradle` file in the model gradle module and import the RxJava using `api` instead of the `implementation`.
2. Go to the `Model` class and comment out the following method `fun broken(flowable: Flowable<Int>)`. The interesting thing is, the build is broken only if we use `Flowable` as an argument of a function, `Flowable` as a return type is OK.
