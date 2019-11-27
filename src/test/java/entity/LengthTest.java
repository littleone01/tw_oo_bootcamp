package entity;

import org.junit.Test;

import static org.junit.Assert.assertEquals;


public class LengthTest {
    @Test
    public void should_return_minus_one_when_is_smaller() {
        Length l1 = new Length(2, Unit.M);
        Length l2 = new Length(3, Unit.M);
        assertEquals(-1, l1.compare(l2));
    }

    @Test
    public void should_return_0_when_two_length_equal() {
        Length l1 = new Length(2, Unit.M);
        Length l2 = new Length(2, Unit.M);
        assertEquals(0, l1.compare(l2));
    }

    @Test
    public void should_return_one_when_is_bigger() {
        Length l1 = new Length(3, Unit.M);
        Length l2 = new Length(2, Unit.M);
        assertEquals(1, l1.compare(l2));
    }

    @Test
    public void should_return_minus_one_when_value_is_bigger_with_diff_unit() {
        Length l1 = new Length(2, Unit.CM);
        Length l2 = new Length(2, Unit.M);
        assertEquals(-1, l1.compare(l2));
    }

    @Test
    public void should_return_0_when_value_is_not_equal_but_with_diff_unit() {
        Length l1 = new Length(20, Unit.DM);
        Length l2 = new Length(2, Unit.M);
        assertEquals(0, l1.compare(l2));
    }

    @Test
    public void should_return_one_when_value_is_equal_but_with_diff_unit() {
        Length l1 = new Length(2, Unit.M);
        Length l2 = new Length(200, Unit.MM);
        assertEquals(1, l1.compare(l2));
    }

    @Test
    public void should_return_l1_when_l1_is_bigger() {
        Length l1 = new Length(2, Unit.M);
        Length l2 = new Length(200, Unit.MM);
        assertEquals(l1, Length.getBiggerOne(l1, l2));
    }

    @Test
    public void should_return_l2_when_l2_is_bigger() {
        Length l1 = new Length(2, Unit.M);
        Length l2 = new Length(200, Unit.M);
        assertEquals(l2, Length.getBiggerOne(l1, l2));
    }

    @Test
    public void should_return_l1_when_l1_l2_equal() {
        Length l1 = new Length(2, Unit.M);
        Length l2 = new Length(200, Unit.CM);
        assertEquals(l1, Length.getBiggerOne(l1, l2));
    }
}