/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package geneticmusic.fitness;

import geneticmusic.rulesInConstruction.PausesAfterShortNotes;
import geneticmusic.rulesInConstruction.NoteDensityRule;
import geneticmusic.rules.RithmContinuity;
import geneticmusic.rules.MelodyContinuity;
import geneticmusic.rules.InScaleRule;
import geneticmusic.domain.Alteration;
import geneticmusic.domain.Note;
import geneticmusic.domain.Pitch;
import java.util.LinkedList;
import jm.constants.Durations;
import jm.constants.Scales;
import org.jgap.FitnessFunction;
import org.jgap.IChromosome;

/**
 *
 * @author Davide Nunes
 */
public class MelodyFitnessFunction extends FitnessFunction{
    
    LinkedList<CompositionRule> rules ;
    
    public MelodyFitnessFunction(){
        //init rule list
        this.rules = new LinkedList<CompositionRule>();
        
        //configure all the rules 
        configRules();
    }
    
    private void configRules(){
        //Normalized rules
        Note tonic = new Note(Pitch.C, 5, Alteration.N, 4);
        InScaleRule inScale = new InScaleRule(Scales.MAJOR_SCALE, tonic, 0.5);
        MelodyContinuity melodyContinuity = new MelodyContinuity(0.5);
    
        RithmContinuity rithmVariety = new RithmContinuity(0.5);
//        RegisterFilterRule octaveFilter = new RegisterFilterRule(0.5);
//        
//        MelodicConsistency melodyContinuity = new MelodicConsistency(0.5);
//         StructureRegularity compassReg = new StructureRegularity(0);
//        
        //--------------------------------------------------------
        
        
        
        //config note density rule
        CompositionRule densityRule = new NoteDensityRule(0.9, Durations.C); 
        
        //rythmic variety rule
       
        
        //PauseRegulationRule pauseReg = new PauseRegulationRule();
        
       
        
        
        
 
        
        PausesAfterShortNotes restsAfterShort = new PausesAfterShortNotes();
        
        //add the rules
        rules.add(inScale);
        rules.add(melodyContinuity);
//        rules.add(compassReg);
//        rules.add(densityRule);
       rules.add(rithmVariety);
//        //rules.add(pauseReg);
//        rules.add(octaveFilter);
//        rules.add(melodyContinuity);
//        rules.add(compassReg);
//        rules.add(restsAfterShort);
        
    
    }
    

    @Override
    protected double evaluate(IChromosome ic) {
        double evaluation = 0.0;
        
        //apply the rules
        for(CompositionRule rule : rules){
            double currentEval = rule.evaluate(ic);
            evaluation += currentEval; //update evaluation with positive or negative value
        
//            
//           System.out.println("rule: "+ rule.getClass().toString());
//            System.out.println("value: "+ currentEval);
        }
        return evaluation;
    }
    
}
