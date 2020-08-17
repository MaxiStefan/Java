package Test;

import java.util.ArrayList;

import Hospital.Adapter.AbstractUnconsciousPatient;
import Hospital.Adapter.AdapterUnconsciousPatient;
import Hospital.Adapter.PatientDescriptionInterface;
import Hospital.Adapter.PleaseHelpPatient;
import Hospital.Adapter.UnconsciousPatient;
import Hospital.ChainMax.BleedFilter;
import Hospital.ChainMax.ConsciousnessFilter;
import Hospital.ChainMax.NoProblemsPatient;
import Hospital.ChainMax.Patient;
import Hospital.ChainMax.TempFilter;
import Hospital.Template.MobileRegistration;
import Hospital.Template.PatientRegistration;
import Hospital.Template.WebInterfaceRegistration;


public class Test {

	public static void main(String[] args) {	
		Patient p1 = new Patient("Max", 25, false, true);
		Patient p2 = new Patient("Irina", 55, false, false);
		Patient p3 = new Patient("Madalina", 25, true, false);
		Patient p4 = new Patient("Alina", 25, false, false);
		
		TempFilter temp = new TempFilter();
		ConsciousnessFilter consc = new ConsciousnessFilter();
		NoProblemsPatient careFree = new NoProblemsPatient();
		BleedFilter bleed = new BleedFilter();
		
		temp.setNext(bleed);
		bleed.setNext(consc);
		consc.setNext(careFree);
		
		temp.processPatient(p1);
		temp.processPatient(p2);
		temp.processPatient(p3);
		temp.processPatient(p4);

		System.out.println("\n");
		
		
		PatientRegistration mobileReg = new MobileRegistration(5);
		mobileReg.registerPatient();
		
		PatientRegistration webReg = new WebInterfaceRegistration(10);
		webReg.registerPatient();
		
		
		ArrayList<PatientDescriptionInterface> patients = new ArrayList<>();
		patients.add(new PleaseHelpPatient("bleeding"));
		patients.add(new PleaseHelpPatient("dying"));
		
		for(PatientDescriptionInterface patient : patients) {
			patient.getDescription();
		}
		
		AbstractUnconsciousPatient unconsciousPatient1 = new UnconsciousPatient("Madalina");
		AdapterUnconsciousPatient adapterUnconsciousPatient = new AdapterUnconsciousPatient(unconsciousPatient1);
		patients.add(adapterUnconsciousPatient);
		
		for(PatientDescriptionInterface patient : patients) {
			patient.getDescription();
		}
	}
}
