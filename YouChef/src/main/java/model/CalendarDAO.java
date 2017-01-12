package model;

import java.util.List;

public interface CalendarDAO {
	public int insert(CalendarBean bean);
	public CalendarBean selectMchef(int mc_id, String date);
	public CalendarBean selectChef(int c_id, String date);
	public CalendarBean update(CalendarBean bean);
	public List<CalendarBean> selectChef(int c_id);
	public List<CalendarBean> selectMchef(int mc_id);
}
