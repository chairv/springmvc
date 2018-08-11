package pipeline;

public interface Pipe<IN, OUT> {

    void setNextPipe(Pipe<?, ?> nextPipe);


    void process(IN input) throws InterruptedException;

}
