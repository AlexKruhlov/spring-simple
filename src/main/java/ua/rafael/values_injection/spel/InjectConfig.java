package ua.rafael.values_injection.spel;

import org.springframework.stereotype.Component;

@Component("injectConfig")
public class InjectConfig {
	private String name = "Chris Baker";
	private int age = 32;
	private float heigh = 1.788f;
	private boolean programer = true;
	private long ageInSeconds = 1009843200L;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public float getHeigh() {
		return heigh;
	}

	public void setHeigh(float heigh) {
		this.heigh = heigh;
	}

	public boolean isProgramer() {
		return programer;
	}

	public void setProgramer(boolean programer) {
		this.programer = programer;
	}

	public long getAgeInSeconds() {
		return ageInSeconds;
	}

	public void setAgeInSeconds(long ageInSeconds) {
		this.ageInSeconds = ageInSeconds;
	}
}
