package design.medium;

import java.util.NoSuchElementException;

class Vector2DIterator {
    int[][] vector;
    int inner = 0;
    int outer = 0;

    public Vector2DIterator(int[][] vec) {
        vector=vec;
    }

    public int next() {
        if(!hasNext()) throw new NoSuchElementException();
        return vector[outer][inner++];
    }

    public boolean hasNext() {
        advanceToNext();
        return outer < vector.length;
    }

    private void advanceToNext() {
        while (outer < vector.length && inner == vector[outer].length) {
            inner = 0;
            outer++;
        }
    }
}
