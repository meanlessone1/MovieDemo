package movie;

public class Movie {
	// 필드

	private String movieName;// 영화명

	private int price;// 금액

	private int age;// 나이

	private String way;// 구매방법
	
	private int money;// 실구매금액

	private double rate;// 할인율

	
	public String getMovieName() {
		return movieName;
	}

	public void setMovieName(String movieName) {
		this.movieName = movieName;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	public String getWay() {
		return way;
	}

	public void setWay(String way) {
		this.way = way;
	}

	public void setRate(double rate) {
		this.rate = rate;
	}

	public double getRate() {
		return rate;
	}

	// 생성자

	public Movie(String movieName, int price, int age, String way) {

		// 매개변수로 값을 받아서 멤버변수에 넣기

		setMovieName(movieName);
		;

		setPrice(price);
		;

		setAge(age);
		;

		setWay(way);

	}

	public void rateCal() { // 할인율

		double ratecal = 0.0;

		switch (getWay()) {
		case "인터넷":
			ratecal += 0.05;
			break;

		case "현장":
			ratecal += 0.0;
			break;

		case "쿠폰":
			ratecal += 0.1;
			break;

		}

		if (getAge() < 20) {
			ratecal += 0.25;
		} else if (getAge()  >= 30) {
			ratecal += 0.15;
		} else {
			ratecal += 0.2;
		}

		setRate(ratecal);

	}

	public void moneyCal() {// 실결제 금액
		
		int monecal = (int)(getPrice() -(getPrice()*getRate()));
		setMoney(monecal);

	}

	public static void titlePrint() {// 제목 출력
		System.out.println("영화명\t금액\t나이\t실구매 금액");
	}

	public void dataPrint() {// 예매 내용 출력
		rateCal();
		moneyCal();
		System.out.printf("%s\t%d\t%d\t%d\n", getMovieName(), getPrice(), getAge(), getMoney());
	}
}
