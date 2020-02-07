package com.jntm.a_创建和销毁对象.避免使用终结方法和清除方法;

import java.lang.ref.Cleaner;

public class Room implements AutoCloseable {
    private static final Cleaner cleaner = Cleaner.create();

    private static class State implements Runnable {
        int junkPiles;

        public State(int junkPiles) {
            this.junkPiles = junkPiles;
        }

        @Override
        public void run() {
            System.out.println("clean up");
            junkPiles = 0;
        }
    }

    private final State state;

    private final Cleaner.Cleanable cleanable;

    public Room(int junkPiles) {
        state = new State(junkPiles);
        cleanable = cleaner.register(this, state);
    }

    @Override
    public void close() throws Exception {
        cleanable.clean();
    }
}
