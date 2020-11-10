package entities;

public class FisicalPerson extends Person {

	private Double healthExpenses;

	public FisicalPerson() {
		super();
	}

	public FisicalPerson(String name, Double annualIncome, Double healthExpenses) {
		super(name, annualIncome);
		this.healthExpenses = healthExpenses;
	}

	public Double getHealthExpenses() {
		return healthExpenses;
	}

	public void setHealthExpenses(Double healthExpenses) {
		this.healthExpenses = healthExpenses;
	}

	@Override
	public Double tax() {
		if (getAnnualIncome() < 0.0) {
			return 0.0;
		} 
		else if (getAnnualIncome() < 20000.0) {
			return getAnnualIncome() * 0.15;
		}

		else if (getHealthExpenses() != null) {
			return getAnnualIncome() * 0.25 - getHealthExpenses() * 0.50;
		}

		else {
			return getAnnualIncome() * 0.25;
		}
		//return (getAnnualIncome() < 20000.0) ? getAnnualIncome() * 0.15 : getAnnualIncome() * 0.25;
	}
	
}
