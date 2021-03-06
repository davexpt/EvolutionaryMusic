/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package geneticmusic.fitness;

import geneticmusic.genes.Note;
import geneticmusic.jmusic.bridge.ConverterUtil;
import jm.music.data.Phrase;
import jm.music.tools.PhraseAnalysis;
import org.jgap.Gene;
import org.jgap.IChromosome;

/**
 * Reduce the jumps in a melody
 * 
 * @author Davide Nunes
 */
public class MelodicConsistency implements CompositionRule {
    
    double weight;
    
    public MelodicConsistency(double weight){
        this.weight = weight;
    }
    

    @Override
    public double evaluate(IChromosome ic) {
        double result = 0.0;
        Gene genes[] = ic.getGenes();

        for (int i = 0; i < genes.length - 1; i++) {
            Note currentNote = (Note) genes[i].getAllele();
            Note nextNote = (Note) genes[i + 1].getAllele();

            double distance = currentNote.distance(nextNote);
            distance = Math.abs(distance);

            
             //System.out.println("distance " + distance);
            
            if(distance < 2 && currentNote.getOctave() > 3 && currentNote.getOctave() <5){
                result +=  1/(genes.length*1.0);
                //System.out.println("bonus");
            }
            else
                 result +=  -1/(genes.length*1.0);
        }
        
        
        
      
        
        return weight*result;
    }
}
