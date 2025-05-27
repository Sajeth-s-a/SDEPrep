package pubsub;

import java.util.Map;

public class Broker
{
	private Map<String, Topic> topicMap;

	public void createTopic(String topicName, int partitions)
	{
		if (topicMap.containsKey(topicName))
		{
			throw new IllegalArgumentException("Topic already exists: " + topicName);
		}
		topicMap.put(topicName, new Topic(topicName, partitions));
	}

	public Topic getTopic(String name)
	{
		return topicMap.get(name);
	}
}
