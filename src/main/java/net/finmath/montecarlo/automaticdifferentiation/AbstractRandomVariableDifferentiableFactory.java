/*
 * (c) Copyright Christian P. Fries, Germany. Contact: email@christianfries.com.
 *
 * Created on 02.07.2017
 */

package net.finmath.montecarlo.automaticdifferentiation;

import net.finmath.montecarlo.AbstractRandomVariableFactory;
import net.finmath.montecarlo.RandomVariableFactory;
import net.finmath.stochastic.RandomVariable;

/**
 * A random variable factory extending <code>AbstractRandomVariableFactory</code> providing
 * random variables implementing <code>RandomVariableDifferentiable</code>.
 *
 * @author Christian Fries
 * @version 1.0
 */
public abstract class AbstractRandomVariableDifferentiableFactory extends AbstractRandomVariableFactory {

	/**
	 *
	 */
	private static final long serialVersionUID = 8262731847824139905L;
	private final AbstractRandomVariableFactory randomVariableFactoryForNonDifferentiable;

	/**
	 * Construct an object extending <code>AbstractRandomVariableDifferentiableFactory</code>
	 * with a specific <code>AbstractRandomVariableFactory</code> for the storage of values.
	 *
	 * @param randomVariableFactoryForNonDifferentiable Random variable factory to be used for the storage of values.
	 */
	public AbstractRandomVariableDifferentiableFactory(AbstractRandomVariableFactory randomVariableFactoryForNonDifferentiable) {
		super();
		this.randomVariableFactoryForNonDifferentiable = randomVariableFactoryForNonDifferentiable;
	}

	public AbstractRandomVariableDifferentiableFactory() {
		this(new RandomVariableFactory());
	}

	@Override
	public RandomVariableDifferentiable createRandomVariable(double value) {
		return createRandomVariable(0.0, value);
	}

	@Override
	public abstract RandomVariableDifferentiable createRandomVariable(double time, double value);

	@Override
	public abstract RandomVariableDifferentiable createRandomVariable(double time, double[] values);

	public RandomVariable createRandomVariableNonDifferentiable(double time, double value) {
		return randomVariableFactoryForNonDifferentiable.createRandomVariable(time, value);
	}

	public RandomVariable createRandomVariableNonDifferentiable(double time, double[] values) {
		return randomVariableFactoryForNonDifferentiable.createRandomVariable(time, values);
	}

	@Override
	public String toString() {
		return "AbstractRandomVariableDifferentiableFactory [randomVariableFactoryForNonDifferentiable="
				+ randomVariableFactoryForNonDifferentiable + "]";
	}
}
