/*
 * (c) Copyright Christian P. Fries, Germany. All rights reserved. Contact: email@christian-fries.de.
 *
 * Created on 01.03.2008
 */
package net.finmath.initialmargin.isdasimm.changedfinmath;

import java.util.Map;

import net.finmath.exception.CalculationException;
import net.finmath.stochastic.RandomVariable;

/**
 * Extension of the original interface net.finmath.montecarlo.interestrate.LIBORModelMonteCarloSimulationModel
 *
 * @author Mario Viehmann
 * @author Christian Fries
 * @version 1.0
 */

public interface LIBORModelMonteCarloSimulationInterface extends net.finmath.montecarlo.interestrate.LIBORModelMonteCarloSimulationModel {

	/**
	 * Returns the map of <code> Double <code> (time) and <code> RandomVariable <code> (numeraire Adjustment)
	 *
	 * @return The numeraire adjustment map
	 */
	Map<Double, RandomVariable> getNumeraireAdjustmentMap();

	/**
	 * Returns the numeraire adjustment
	 *
	 * @param time The time
	 * @return
	 * @throws CalculationException
	 */
	RandomVariable getNumeraireOISAdjustmentFactor(double time) throws CalculationException;

	/**
	 * Returns the forward bond P(T;t) on the forward curve. Calculated directly from Libors without using conditional expectation
	 *
	 * @param T final time
	 * @param t initial time
	 * @return P(T ; t)
	 * @throws CalculationException
	 */
	RandomVariable getForwardBondLibor(double T, double t) throws CalculationException;

	/**
	 * Returns the forward bond P(T;t) from on the OIS curve for a given Libor market model
	 *
	 * @param T The maturity of the forward bond
	 * @param t The inception of the forward bond
	 * @return The forward bond P(T;t) on the OIS curve
	 * @throws CalculationException
	 */
	RandomVariable getForwardBondOIS(double T, double t) throws CalculationException;
}