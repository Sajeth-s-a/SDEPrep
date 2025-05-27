package pubsub;

import java.util.ArrayList;
import java.util.List;

public class Partition
{
	private final List<Message> messages = 	new ArrayList<>();
	private int nextOffset = 0;

	public synchronized void addMessage(String data)
	{
		messages.add(new Message(nextOffset++, data));
	}

	public synchronized List<Message> getMessages(int offSet, int limit)
	{
		int end = Math.min(offSet + limit, nextOffset);
		return new ArrayList<>(messages.subList(
			offSet, end
		));
	}

	public int getLatestOffset()
	{
		if (messages.isEmpty())
		{
			return -1; // No messages available
		}
		return nextOffset;
	}
}
