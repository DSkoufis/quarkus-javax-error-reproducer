Ref: https://stackoverflow.com/q/76738232/7326551

Run:

```shell
./mvnw clean verify -Dnative -Dquarkus.native.container-build=true
```

Error:

```text
Fatal error: com.oracle.graal.pointsto.util.AnalysisError$ParsingError: Error encountered while parsing org.javamoney.moneta.spi.PriorityAwareServiceProvider$$Lambda$1019/0x00000001013c4000.compare(Unknown Source)
Parsing context:
   at java.util.TimSort.binarySort(TimSort.java:296)
   at java.util.TimSort.sort(TimSort.java:239)
   at java.util.Arrays.sort(Arrays.java:1307)
   at java.util.ArrayList.sort(ArrayList.java:1721)
   at com.oracle.svm.common.option.CommonOptionParser.printFlags(CommonOptionParser.java:493)
   at com.oracle.svm.core.option.RuntimeOptionParser.parseOptionAtRuntime(RuntimeOptionParser.java:161)
   at com.oracle.svm.core.option.RuntimeOptionParser.parse(RuntimeOptionParser.java:128)
   at com.oracle.svm.core.option.RuntimeOptionParser.parseAndConsumeAllOptions(RuntimeOptionParser.java:81)
   at com.oracle.svm.core.graal.snippets.CEntryPointSnippets.initializeIsolate(CEntryPointSnippets.java:330)
   at static root method.(Unknown Source)

	at org.graalvm.nativeimage.pointsto/com.oracle.graal.pointsto.util.AnalysisError.parsingError(AnalysisError.java:149)
	at org.graalvm.nativeimage.pointsto/com.oracle.graal.pointsto.flow.MethodTypeFlow.createFlowsGraph(MethodTypeFlow.java:178)
	at org.graalvm.nativeimage.pointsto/com.oracle.graal.pointsto.flow.MethodTypeFlow.ensureFlowsGraphCreated(MethodTypeFlow.java:152)
	at org.graalvm.nativeimage.pointsto/com.oracle.graal.pointsto.flow.MethodTypeFlow.getOrCreateMethodFlowsGraphInfo(MethodTypeFlow.java:110)
	at org.graalvm.nativeimage.pointsto/com.oracle.graal.pointsto.typestate.DefaultVirtualInvokeTypeFlow.onObservedUpdate(DefaultVirtualInvokeTypeFlow.java:113)
	at org.graalvm.nativeimage.pointsto/com.oracle.graal.pointsto.flow.TypeFlow.update(TypeFlow.java:583)
	at org.graalvm.nativeimage.pointsto/com.oracle.graal.pointsto.PointsToAnalysis$1.run(PointsToAnalysis.java:474)
	at org.graalvm.nativeimage.pointsto/com.oracle.graal.pointsto.util.CompletionExecutor.executeCommand(CompletionExecutor.java:187)
	at org.graalvm.nativeimage.pointsto/com.oracle.graal.pointsto.util.CompletionExecutor.lambda$executeService$0(CompletionExecutor.java:171)
	at java.base/java.util.concurrent.ForkJoinTask$RunnableExecuteAction.exec(ForkJoinTask.java:1395)
	at java.base/java.util.concurrent.ForkJoinTask.doExec(ForkJoinTask.java:373)
	at java.base/java.util.concurrent.ForkJoinPool$WorkQueue.topLevelExec(ForkJoinPool.java:1182)
	at java.base/java.util.concurrent.ForkJoinPool.scan(ForkJoinPool.java:1655)
	at java.base/java.util.concurrent.ForkJoinPool.runWorker(ForkJoinPool.java:1622)
	at java.base/java.util.concurrent.ForkJoinWorkerThread.run(ForkJoinWorkerThread.java:165)
Caused by: org.graalvm.compiler.java.BytecodeParser$BytecodeParserError: com.oracle.graal.pointsto.constraints.UnresolvedElementException: Discovered unresolved type during parsing: javax.annotation.Priority. This error is reported at image build time because class org.javamoney.moneta.spi.PriorityAwareServiceProvider is registered for linking at image build time by command line
	at parsing org.javamoney.moneta.spi.PriorityAwareServiceProvider.compareServices(PriorityAwareServiceProvider.java:72)
	at jdk.internal.vm.compiler/org.graalvm.compiler.java.BytecodeParser.throwParserError(BytecodeParser.java:2536)
	at org.graalvm.nativeimage.builder/com.oracle.svm.hosted.phases.SharedGraphBuilderPhase$SharedBytecodeParser.throwParserError(SharedGraphBuilderPhase.java:169)
	at jdk.internal.vm.compiler/org.graalvm.compiler.java.BytecodeParser.iterateBytecodesForBlock(BytecodeParser.java:3414)
	at org.graalvm.nativeimage.builder/com.oracle.svm.hosted.phases.SharedGraphBuilderPhase$SharedBytecodeParser.iterateBytecodesForBlock(SharedGraphBuilderPhase.java:712)
	at jdk.internal.vm.compiler/org.graalvm.compiler.java.BytecodeParser.handleBytecodeBlock(BytecodeParser.java:3366)
	at jdk.internal.vm.compiler/org.graalvm.compiler.java.BytecodeParser.processBlock(BytecodeParser.java:3208)
	at jdk.internal.vm.compiler/org.graalvm.compiler.java.BytecodeParser.build(BytecodeParser.java:1134)
	at org.graalvm.nativeimage.builder/com.oracle.svm.hosted.phases.SharedGraphBuilderPhase$SharedBytecodeParser.build(SharedGraphBuilderPhase.java:152)
	at jdk.internal.vm.compiler/org.graalvm.compiler.java.BytecodeParser.buildRootMethod(BytecodeParser.java:1026)
	at jdk.internal.vm.compiler/org.graalvm.compiler.java.GraphBuilderPhase$Instance.run(GraphBuilderPhase.java:97)
	at org.graalvm.nativeimage.builder/com.oracle.svm.hosted.phases.SharedGraphBuilderPhase.run(SharedGraphBuilderPhase.java:114)
	at jdk.internal.vm.compiler/org.graalvm.compiler.phases.Phase.run(Phase.java:49)
	at jdk.internal.vm.compiler/org.graalvm.compiler.phases.BasePhase.apply(BasePhase.java:434)
	at jdk.internal.vm.compiler/org.graalvm.compiler.phases.Phase.apply(Phase.java:42)
	at jdk.internal.vm.compiler/org.graalvm.compiler.phases.Phase.apply(Phase.java:38)
	at org.graalvm.nativeimage.pointsto/com.oracle.graal.pointsto.flow.AnalysisParsedGraph.parseBytecode(AnalysisParsedGraph.java:146)
	at org.graalvm.nativeimage.pointsto/com.oracle.graal.pointsto.meta.AnalysisMethod.parseGraph(AnalysisMethod.java:819)
	at org.graalvm.nativeimage.pointsto/com.oracle.graal.pointsto.meta.AnalysisMethod.ensureGraphParsedHelper(AnalysisMethod.java:784)
	at org.graalvm.nativeimage.pointsto/com.oracle.graal.pointsto.meta.AnalysisMethod.ensureGraphParsed(AnalysisMethod.java:767)
	at org.graalvm.nativeimage.pointsto/com.oracle.graal.pointsto.phases.InlineBeforeAnalysisGraphDecoder.lookupEncodedGraph(InlineBeforeAnalysisGraphDecoder.java:120)
	at jdk.internal.vm.compiler/org.graalvm.compiler.replacements.PEGraphDecoder.doInline(PEGraphDecoder.java:1190)
	at jdk.internal.vm.compiler/org.graalvm.compiler.replacements.PEGraphDecoder.tryInline(PEGraphDecoder.java:1173)
	at jdk.internal.vm.compiler/org.graalvm.compiler.replacements.PEGraphDecoder.trySimplifyInvoke(PEGraphDecoder.java:1028)
	at jdk.internal.vm.compiler/org.graalvm.compiler.replacements.PEGraphDecoder.handleInvoke(PEGraphDecoder.java:982)
	at jdk.internal.vm.compiler/org.graalvm.compiler.nodes.GraphDecoder.processNextNode(GraphDecoder.java:871)
	at org.graalvm.nativeimage.pointsto/com.oracle.graal.pointsto.phases.InlineBeforeAnalysisGraphDecoder.processNextNode(InlineBeforeAnalysisGraphDecoder.java:186)
	at jdk.internal.vm.compiler/org.graalvm.compiler.nodes.GraphDecoder.decode(GraphDecoder.java:600)
	at jdk.internal.vm.compiler/org.graalvm.compiler.replacements.PEGraphDecoder.decode(PEGraphDecoder.java:854)
	at org.graalvm.nativeimage.pointsto/com.oracle.graal.pointsto.phases.InlineBeforeAnalysis.decodeGraph(InlineBeforeAnalysis.java:77)
	at org.graalvm.nativeimage.pointsto/com.oracle.graal.pointsto.flow.MethodTypeFlowBuilder.parse(MethodTypeFlowBuilder.java:193)
	at org.graalvm.nativeimage.pointsto/com.oracle.graal.pointsto.flow.MethodTypeFlowBuilder.apply(MethodTypeFlowBuilder.java:583)
	at org.graalvm.nativeimage.pointsto/com.oracle.graal.pointsto.flow.MethodTypeFlow.createFlowsGraph(MethodTypeFlow.java:165)
	... 13 more
Caused by: com.oracle.graal.pointsto.constraints.UnresolvedElementException: Discovered unresolved type during parsing: javax.annotation.Priority. This error is reported at image build time because class org.javamoney.moneta.spi.PriorityAwareServiceProvider is registered for linking at image build time by command line
	at org.graalvm.nativeimage.builder/com.oracle.svm.hosted.phases.SharedGraphBuilderPhase$SharedBytecodeParser.reportUnresolvedElement(SharedGraphBuilderPhase.java:521)
	at org.graalvm.nativeimage.builder/com.oracle.svm.hosted.phases.SharedGraphBuilderPhase$SharedBytecodeParser.reportUnresolvedElement(SharedGraphBuilderPhase.java:515)
	at org.graalvm.nativeimage.builder/com.oracle.svm.hosted.phases.SharedGraphBuilderPhase$SharedBytecodeParser.handleUnresolvedType(SharedGraphBuilderPhase.java:407)
	at org.graalvm.nativeimage.builder/com.oracle.svm.hosted.phases.SharedGraphBuilderPhase$SharedBytecodeParser.handleUnresolvedLoadConstant(SharedGraphBuilderPhase.java:318)
	at jdk.internal.vm.compiler/org.graalvm.compiler.java.BytecodeParser.genLoadConstant(BytecodeParser.java:3967)
	at jdk.internal.vm.compiler/org.graalvm.compiler.java.BytecodeParser.processBytecode(BytecodeParser.java:5167)
	at jdk.internal.vm.compiler/org.graalvm.compiler.java.BytecodeParser.iterateBytecodesForBlock(BytecodeParser.java:3406)
	... 42 more
```

`Moneta` is using `javax.annotation` and AWS dynamoDB is using `jakarta.annotation`.
