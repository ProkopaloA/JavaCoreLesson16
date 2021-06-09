package ua.lviv.lgs;

public class Person implements Human {
	public String name;
	public int age;
	private int ID;
	private String hobby;
	private String meatEater = " Meat-eater ";

	public Person() {
	}

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public Person(String name, int age, int iD, String hobby, String meatEater) {
		super();
		this.name = name;
		this.age = age;
		ID = iD;
		this.hobby = hobby;
		this.meatEater = meatEater;
	}

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

	public int getID() {
		return ID;
	}

	public void setID(int iD) {
		ID = iD;
	}

	public String getHobby() {
		return hobby;
	}

	public void setHobby(String hobby) {
		this.hobby = hobby;
	}

	public String getMeatEater() {
		return meatEater;
	}

	public void setMeatEater(String meatEater) {
		this.meatEater = meatEater;
	}
	
	public void doSmth(String name){
        System.out.println(this.name + " do smth... For example work");
    }
	public void agePlusTen(int age) {
		System.out.println("The age after 10 year will be " + (age+10));
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ID;
		result = prime * result + age;
		result = prime * result + ((hobby == null) ? 0 : hobby.hashCode());
		result = prime * result + ((meatEater == null) ? 0 : meatEater.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (ID != other.ID)
			return false;
		if (age != other.age)
			return false;
		if (hobby == null) {
			if (other.hobby != null)
				return false;
		} else if (!hobby.equals(other.hobby))
			return false;
		if (meatEater == null) {
			if (other.meatEater != null)
				return false;
		} else if (!meatEater.equals(other.meatEater))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + ", ID=" + ID + ", hobby=" + hobby + ", meatEater=" + meatEater
				+ "]";
	}

}
