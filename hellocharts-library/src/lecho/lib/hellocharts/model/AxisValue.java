package lecho.lib.hellocharts.model;

import java.util.Arrays;

/**
 * Single axis value, use it to manually set axis labels position. You can use label attribute to display text instead
 * of number but value formatter implementation have to handle it.
 * 
 */
public class AxisValue {
    private float value;
    private char[] label;
    private int color = -1;

    public AxisValue(float value) {
		setValue(value);
	}

    public AxisValue(float value, char[] label) {
        setValue(value);
        setLabel(label);
    }

	public AxisValue(float value, char[] label, int color) {
		this.value = value;
        this.label = label;
        this.color = color;
	}

	public AxisValue(AxisValue axisValue) {
		this.value = axisValue.value;
        this.label = axisValue.label;
        this.color = axisValue.color;
	}

	public float getValue() {
		return value;
	}

	public AxisValue setValue(float value) {
		this.value = value;
		return this;
	}

    public char[] getLabel() {
        return label;
    }

    /**
     * Set custom label for this axis value.
     *
     * @param label
     */
    public AxisValue setLabel(char[] label) {
        this.label = label;
        return this;
    }

    public int getColor() {
        return color;
    }

    /**
     * Set custom color for this axis value.
     *
     * @param color
     */
    public AxisValue setLabel(int color) {
        this.color = color;
        return this;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        AxisValue axisValue = (AxisValue) o;

        if (Float.compare(axisValue.value, value) != 0) return false;
        if (!Arrays.equals(label, axisValue.label)) return false;
        if (axisValue.color != color) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = (value != +0.0f ? Float.floatToIntBits(value) : 0);
        result = 31 * result + (label != null ? Arrays.hashCode(label) : 0);
        return result;
    }
}