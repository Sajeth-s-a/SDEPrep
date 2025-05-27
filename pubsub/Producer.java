package pubsub;

public class Producer
{
	private final Broker broker;

	public Producer(Broker broker)
	{
		this.broker = broker;
	}

	public void send(String topicName, String message)
	{
		Topic topic = broker.getTopic(topicName);
		if (topic != null)
		{
			topic.publish(message);
		}
	}
}