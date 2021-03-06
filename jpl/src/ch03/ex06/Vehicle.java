/**
 *
 */
package ch03.ex06;

/**
 * @author mary-mogreen
 * 3.6 EnergySource追加
 */
public class Vehicle {
	private double speed = 0.0; // 速度(km/h)
	private double angle = 0.0; // 方向(°)
	private String owner; // 所有者の名前
	private EnergySource energySource;
	private final long id; // 識別番号

	static final int TURN_LEFT = 0;
	static final int TURN_RIGHT = 1;

	/**
	 * 初期化
	 */
	public Vehicle() {
		id = nextID++;
	}

	/**
	 * 所有者の名前つき初期化
	 *
	 * @param owner
	 */
	public Vehicle(String owner) {
		this.owner = owner;
		id = nextID++;
	}

	/**
	 * EnergySourceを保持
	 *
	 * @param energySource
	 */
	public Vehicle(EnergySource energySource) {
		this.energySource = energySource;
		id = nextID++;
	}

	/**
	 * EnergySourceを保持 & 所有者の名前つき
	 *
	 * @param energySource
	 */
	public Vehicle(String owner, EnergySource energySource) {
		this.owner = owner;
		this.energySource = energySource;
		id = nextID++;
	}

	public static long nextID = 0; // 次の識別番号

	/**
	 * Vehicleの情報をプリントする
	 */
	public void printVehicleInfo() {
		System.out.println("===== ID: " + id + " =====");
		System.out.println("Owner: " + owner);
		System.out.println("Speed: " + speed + "km/h");
		System.out.println("Angle: " + angle + "°");
	}

	/**
	 * 現在の識別番号でもっとも大きな値を返す
	 *
	 * @return
	 */
	public static final long getCurrentMaxID() {
		return nextID - 1;
	}

	/**
	 * VehicleのtoStringメソッド
	 */
	public String toString() {
		String desc = "ID: " + id;
		if (owner != null)
			desc += "(owner: " + owner + ") / ";
		desc += "speed: " + speed + "km/h / ";
		desc += "angle: " + angle + "°";
		return desc;
	}

	/**
	 * speedのgetter
	 *
	 * @return
	 */
	public final double getSpeed() {
		return speed;
	}

	/**
	 * speedのsetter
	 *
	 * @param speed
	 */
	public void setSpeed(double speed) {
		this.speed = speed;
	}

	/**
	 * スピードを変更する
	 *
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
	 *
	 * @return
	 */
	public final double getAngle() {
		return angle;
	}

	/**
	 * angleのsetter
	 *
	 * @param angle
	 */
	public void setAngle(double angle) {
		this.angle = angle;
	}

	/**
	 * angleを受け取り回転する角度を更新する
	 *
	 * @param angle
	 */
	public void turn(double angle) {
		setAngle((this.angle + angle) % 360.0);
	}

	/**
	 * Vehicle.TURN_LEFT or Vehicle.TURN_RIGHTを受け取る
	 *
	 * @param turn
	 */
	public void turn(int turn) {
		switch (turn) {
		case TURN_LEFT:
			turn(-90.0);
			break;
		case TURN_RIGHT:
			turn(90.0);
			break;
		default:
			System.out.println("do nothing");
			break;
		}
	}

	/**
	 * nameのgetter
	 *
	 * @return
	 */
	public final String getOwner() {
		return owner;
	}

	/**
	 * nameのsetter
	 *
	 * @param name
	 */
	public void setOwner(String owner) {
		this.owner = owner;
	}

	/**
	 * idのgetter
	 *
	 * @return
	 */
	public final long getId() {
		return id;
	}

	/**
	 * 3.6 追加
	 * EnergySourceが空でない事を保証する
	 */
	public void start() {
		if (energySource.empty()) {
			System.out.println("動力源なし...");
		} else {
			System.out.println("スタート");
		}
	}

	/**
	 *
	 * @param args
	 * @throws CapacityOverException
	 */
	public void charge(long energy) throws CapacityOverException {
		this.energySource.setEnergy(energy);
	}

	public static void main(String[] args) {
		Vehicle v = new Vehicle(new GasTank(100L));
		System.out.println("動力源がないとき：");
		v.start();
		System.out.println("動力源追加後");
		try {
			v.charge(99L);
			v.start();
		} catch (CapacityOverException e) {
			// TODO 自動生成された catch ブロック
			e.printStackTrace();
		}

	}
}
