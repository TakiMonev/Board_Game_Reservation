package rooms;

public class Rooms {
	private String name;
	private String phone;
	private String time;
	private int res;
	private int cancel;
	private int accept;
	private int price;
	public int is_res = 0;

	public String getName() {				// 유저 이름 입력 받기
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhone() {					// 예약 시간 입력 받기
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getTime() {					// 예약 시간 입력 받기
		return time;
	}
	public void setTime(String time) {
		this.time = time;
	}
	
	public int getRes() {					// 예약 입력 받기
		return res;
	}
	public void setRes(int res) {
		this.res = res;
	}
	
	public int resCancel() {				// 예약 취소
		return cancel;
	}
	public void setCancel(int cancel) {		
		this.cancel = cancel;
	}
	public int resAccept() {				// 게임 시작
		return accept;
	}
	public void setAccept(int accept) {
		this.accept = accept;
	}
	
	public int getPrice() {					// 가격 설정
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
}
