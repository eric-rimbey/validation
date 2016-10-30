# validation

I was having difficulty explaining my feedback on PR 1690, so I thought I'd just create a demo to show my thinking.

I didn't want to take the time to replicate all of the Result behavior or muddy my explanation with unnecessary generics. Hopefully the oversimplification is tolerable.

One idea is to make all validators objects, instead of having some of them as methods on the ValidationHelper. Another idea is to make it extensible, easy to add new validators. Hopefully these ideas are sufficiently demonstrated in Validator, ValidatorFactory, BasicValidatorsTest, and StandardValidatorsTest.

I don't really understand all of the mechanics of panels, so this last idea might not work, but I wanted to address to issues I saw in the runValidators method:
A. the use of getInstance. This usually indicates a procedural, micro-management style, and it impedes testability and extensibility
B. the long if-then-else-if sequence. This also impedes extensibility and exposes the system to accidental sequence errors as well as errors of omission.

I'm sure it won't translate well to our actual code base, but you can see how I tried to address these latter concerns in PanelData and PanelValidatorsTest

