package mawn;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class MowerTest {

    @Test
    public void testMoveNorth() {
        Lawn lawn = new Lawn(5, 5);
        Mower mower = new Mower(1, 2, 'N', lawn);
        mower.move('A');
        assertEquals(1, mower.getX());
        assertEquals(3, mower.getY());
        assertEquals('N', mower.getOrientation());
    }

    @Test
    public void testMoveEast() {
        Lawn lawn = new Lawn(5, 5);
        Mower mower = new Mower(1, 2, 'E', lawn);
        mower.move('A');
        assertEquals(2, mower.getX());
        assertEquals(2, mower.getY());
        assertEquals('E', mower.getOrientation());
    }

    @Test
    public void testMoveSouth() {
        Lawn lawn = new Lawn(5, 5);
        Mower mower = new Mower(1, 2, 'S', lawn);
        mower.move('A');
        assertEquals(1, mower.getX());
        assertEquals(1, mower.getY());
        assertEquals('S', mower.getOrientation());
    }

    @Test
    public void testMoveWest() {
        Lawn lawn = new Lawn(5, 5);
        Mower mower = new Mower(1, 2, 'W', lawn);
        mower.move('A');
        assertEquals(0, mower.getX());
        assertEquals(2, mower.getY());
        assertEquals('W', mower.getOrientation());
    }

    @Test
    public void testRotateRightFromNorth() {
        Lawn lawn = new Lawn(5, 5);
        Mower mower = new Mower(1, 2, 'N', lawn);
        mower.move('D');
        assertEquals(1, mower.getX());
        assertEquals(2, mower.getY());
        assertEquals('E', mower.getOrientation());
    }

    @Test
    public void testRotateLeftFromNorth() {
        Lawn lawn = new Lawn(5, 5);
        Mower mower = new Mower(1, 2, 'N', lawn);
        mower.move('G');
        assertEquals(1, mower.getX());
        assertEquals(2, mower.getY());
        assertEquals('W', mower.getOrientation());
    }

    @Test
    public void testRotateRightFromEast() {
        Lawn lawn = new Lawn(5, 5);
        Mower mower = new Mower(1, 2, 'E', lawn);
        mower.move('D');
        assertEquals(1, mower.getX());
        assertEquals(2, mower.getY());
    }
    @Test
    void testMoveDirection_D() {
        Mower mower = new Mower(1, 2, 'N', new Lawn(5, 5));
        mower.move('D');
        assertEquals("1 2 E", mower.toString());
    }

}