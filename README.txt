So in the middle of doing other work today, I suddenly thought, "What if you made bits continuous?"  And so of course I immediately ceased being capable of meaningful work.  :P  Here's the idea: represent bits as any real value from [0,1], with the usual operations replaced as so:
a xor b = abs(a-b)  ... OR ... (a-b)^2
a or b  = a+b-ab
a and b = ab
not a   = 1-a

These new operators yield the same results on 1 and 0 as the old operators did, but also accept values between 1 and 0, and given a,b in [0,1] yield a value in [0,1].

Note: (a-b)^2 feels cleaner to me, more pure, continuous differentiable function...but abs(a-b) gives results that make more sense; small significant digits, etc.
Like, I think I tried [0.5]+[1 1] and got some fractional garbage thing with real values in all the non-zero places - but if you multiplied them each by their
place value and summed, you actually still got the right answer (3.5), haha.

I wrote up some classes to implement this functionality, and then tested it on SHA256, to see if I could discern any pattern.
It probably wasn't a fair test, but no, I found no pattern, at least none that seemed meaningful.
I took SHA256 hashes from [0b0] to [0b1], but the moment the bit value changed in the slightest the hash dissolved entirely into noise.
Though, curiously self-similar noise - like, we had the hash of [0b0], and the hash of [0b1], and a heap of hashes X in-between, and while X
bore no resemblance to the hashes on the ends, the hashes in X were quite similar to each other.
Not sure what that's about, not sure if it's meaningful, and I'm not sure how this stuff would behave on a more normal function.
I've sorta run out of steam on this for now, but feel free to mess with it, if you want.
If you run the code from the console, I've colorized the output of sha256, for easier pattern identification.

MIT license.

-Erhannis
