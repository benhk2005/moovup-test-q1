## Moovup Technical Test Q1

Development Environment

```
IntelliJ IDEA 2022.1.1 (Community Edition)
Build #IC-221.5591.52, built on May 11, 2022
Runtime version: 11.0.14.1+1-b2043.45 aarch64
VM: OpenJDK 64-Bit Server VM by JetBrains s.r.o.
macOS 14.3.1
GC: G1 Young Generation, G1 Old Generation
Memory: 2048M
Cores: 10

Kotlin: 221-1.6.21-release-337-IJ5591.52
```

## Source Code
<https://github.com/benhk2005/moovup-test-q1/blob/main/src/main/java/Task1.java>

## Program Result
```
===All possible routes===
A->B->C->D->E->F->G->H
A->B->C->D->E->H
A->B->C->F->E->H
A->B->C->F->G->H
A->B->D->C->F->E->H
A->B->D->C->F->G->H
A->B->D->E->F->G->H
A->B->D->E->H
A->D->B->C->F->E->H
A->D->B->C->F->G->H
A->D->C->F->E->H
A->D->C->F->G->H
A->D->E->F->G->H
A->D->E->H
A->H
===Minimum distance route===
A->H
```