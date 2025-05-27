package pubsub;

import lombok.Getter;

@Getter
public class Message
{
	private final int offset;
	private final String data;

	public Message(int offset, String data)
	{
		this.offset = offset;
		this.data = data;
	}
}
