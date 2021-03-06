/*
 * This file is part of JGAP.
 *
 * JGAP offers a dual license model containing the LGPL as well as the MPL.
 *
 * For licensing information please see the file license.txt included with JGAP
 * or have a look at the top of class org.jgap.Chromosome which representatively
 * includes the JGAP license policy applicable for any file delivered with JGAP.
 */
package examples.gp.paintedDesert;

import org.jgap.*;
import org.jgap.gp.*;
import org.jgap.gp.impl.*;

/**
 * Takes a step to the north or positive y direction.
 *
 * @author Scott Mueller
 * @since 3.2
 */
public class GO_N
    extends AntCommand implements IMutateable {
  /** String containing the CVS revision. Read out via reflection!*/
  private final static String CVS_REVISION = "$Revision: 1.2 $";

  /**
   * Creates a function to go north
   * @param a_conf
   * @throws InvalidConfigurationException
   */
  public GO_N(final GPConfiguration a_conf)
      throws InvalidConfigurationException {
    super(a_conf, 0, CommandGene.VoidClass);
  }

  /**
   * Mutates the gene.
   */
  public CommandGene applyMutation(int index, double a_percentage)
      throws InvalidConfigurationException {
    GO_S mutant = new GO_S(getGPConfiguration());
    return mutant;
  }

  /**
   * Go north if possible
   */
  public void execute_void(ProgramChromosome a_chrom, int a_n, Object[] a_args) {
    AntMap map = getMap(a_chrom);
    map.getAnt().goN(map);
  }

  /**
   * Returns the program listing name.
   */
  public String toString() {
    return "GO-N";
  }
}
