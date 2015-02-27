import java.util.ArrayList;
import java.util.List;

public class FeatureVector extends ArrayList<Double> {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * Label of the feature.
	 */
	int label;

	/**
	 * Constructor
	 * @param l The label of this feature vector.
	 */
	public FeatureVector(int l) {
		label = l;
	}

	/**
	 * @return Returns the label.
	 */
	public int getLabel() {
		return label;
	}

	/**
	 * Calculates the product of this feature vector with vector weights.
	 * @param weights The vector with which the product is calculated.
	 * @return The product of the two vectors.
	 */
	public double product(List<Double> weights) {
		assert(weights.size() == size());

		double result = 0.0;

        for (Double d : this) {
            for(Double d2 : weights) {
                result+= d * d2;
            }
        }

		return result;
	}

	/**
	 * Calculates the (Euclidean) distance between the given vector and this feature vector.
	 * @param vector The vector to calculate the distance to.
	 * @return The distance to vector.
	 */
	public double distance(List<Double> vector) {
		assert(vector.size() == size());

		double result = 0.0;

        for (Double d : this) {
            for(Double d2 : vector) {
                result+= Math.pow(d - d2, 2);
            }
        }

		return Math.sqrt(result);
	}

	/**
	 * Converts this object to a String object.
	 */
	@Override
	public String toString() {
		return "<" + label + ", " + super.toString() + ">";
	}
}
