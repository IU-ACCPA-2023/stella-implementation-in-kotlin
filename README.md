# stella-implementation-in-kotlin
Template for an implementation of Stella in Kotlin.

![Screenshot from Intellij IDEA.](images/idea-demo.png)

## How to throw Stella type errors
In `org.stella` exist simple `StellaTypeException`, which you should throw any time you encounter a type error. 
### Improvements
- [ ] Add more information to the exception, like the line number and the file name.
- [ ] Add functionality in `StellaTypeException` for each type error.
