/**
 *
 */
package ch06.ex02;

/**
 * @author mary-mogreen
 *
 */
public class Vehicle {
	private double speed = 0.0; // 速度(km/h)
	private double angle = 0.0; // 方向(°)
	private String name; // 所有者の名前
	private final long id; // 識別番号

	/**
	 * 6.2 enumで書き換え
	 * @author mary-mogreen
	 *
	 */
	enum Direction {
		TURN_RIGHT, TURN_LEFT
	}


	/**
	 * 初期化
	 */
	public Vehicle() {
		id = nextID++;
	}

	/**
	 * 所有者の名前つき初期化
	 * @param name
	 */
	public Vehicle(String name) {
		this.name = name;
		id = nextID++;
	}

	public static long nextID = 0; // 次の識別番号

	/**
	 * Vehicleの情報をプリントする
	 */
	public void printVehicleInfo() {
		System.out.println("===== ID: " + id + " =====");
		System.out.println("Owner: " + name);
		System.out.println("Speed: " + speed + "km/h");
		System.out.println("Angle: " + angle + "°");
	}

	/**
	 * 現在の識別番号でもっとも大きな値を返す
	 * @return
	 */
	public static long getCurrentMaxID() {
		return nextID - 1;
	}

	/**
	 * VehicleのtoStringメソッド
	 */
	public String toString() {
		String desc = "ID: " + id;
		if (name != null)
			desc += "(owner: " + name + ") / ";
		desc += "speed: " + speed + "km/h / ";
		desc += "angle: " + angle + "°";
		return desc;
	}

	/**
	 * speedのgetter
	 * @return
	 */
	public double getSpeed() {
		return speed;
	}

	/**
	 * speedのsetter
	 * @param speed
	 */
	public void setSpeed(double speed) {
		this.speed = speed;
	}

	/**
	 * スピードを変更する
	 * @param speed
	 */
	public void changeSpeed(double speed) {
		setSpeed(speed);
	}

	/**
	 * スピードをゼロにする
	 */
	public void stop() {
		setSpeed(0.0);
	}

	/**
	 * angleのgetter
	 * @return
	 */
	public double getAngle() {
		return angle;
	}

	/**
	 * angleのsetter
	 * @param angle
	 */
	public void setAngle(double angle) {
		this.angle = angle;
	}

	/**
	 * angleを受け取り回転する角度を更新する
	 * @param angle
	 */
	public void turn(double angle) {
		setAngle((this.angle + angle) % 360.0);
	}

	/**
	 * Vehicle.TURN_LEFT or Vehicle.TURN_RIGHTを受け取る
	 * @param turn
	 */
	public void turn(Direction direction) {
		switch (direction) {
			case TURN_LEFT:
				setAngle((this.angle - 90.0) % 360.0);
				break;
			case TURN_RIGHT:
				setAngle((this.angle + 90.0) % 360.0);
				break;
			default:
				System.out.println("do nothing");
				break;
		}
	}

	/**
	 * nameのgetter
	 * @return
	 */
	public String getName() {
		return name;
	}

	/**
	 * nameのsetter
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * idのgetter
	 * @return
	 */
	public long getId() {
		return id;
	}

	public static void main(String[] args) {
		Vehicle[] vehicles = new Vehicle[3];
		for (int i = 0; i < 3; i++) {
			vehicles[i] = new Vehicle("owner" + i);
			vehicles[i].changeSpeed(100.0 * (i + 1));
			vehicles[i].setAngle((i + 1) * 90.0);
		}

		vehicles[2].turn(180.2);

		for (int i = 0; i < 3; i++) {
			vehicles[i].printVehicleInfo();
		}

		vehicles[1].turn(Direction.TURN_LEFT);

		for (int i = 0; i < 3; i++) {
			vehicles[i].printVehicleInfo();
		}
	}
}
