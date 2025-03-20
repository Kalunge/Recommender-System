# Java Streams
- from a general point of view a Stream is a continuous sequence or flow of some elements
- from a pure java technical point a stream is a typed interface

```java
import java.util.stream.*;

public interface Stream<T> extends BaseStream<T, Stream<T>>{
    
}
```
- the stream interface represents a sequence, maybe finite or not-finite, of elements of type T.
- A stream is said to be bounded if it contains finite elements or unbounded if it does not represent a finite number of elements

## What does a Stream hold
- maybe, because of the fact that a stream represents continous flow of data, we may tend to think that it holds the data. but it does not
- Yes, a `Stream` 