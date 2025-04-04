package ass.dao;

import java.util.List;

import ass.classes.LiveItem;

public interface LiveItemDAO {

	void addLiveItem(LiveItem liveitem);

	LiveItem getLiveItem(int id);

	List<LiveItem> getAll();

	void updateLiveItem(LiveItem liveitem);

	void deleteLiveItem(int id);

}
