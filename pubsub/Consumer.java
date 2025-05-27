package pubsub;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Consumer
{
	private final Broker broker;
	private final Map<String, Map<Integer, Integer>> offsets = new HashMap<>(); // topic -> (partition -> offset)

	public Consumer(Broker broker)
	{
		this.broker = broker;
	}

	public List<Message> poll(String topicName, int partitionNo, int limit)
	{
		Topic topic = broker.getTopic(topicName);
		if (topic == null)
		{
			throw new IllegalArgumentException("Topic does not exist: " + topicName);
		}

		Partition partition = topic.getPartition(partitionNo);

		int offset = getOffset(topicName, partitionNo);
		List<Message> messages = partition.getMessages(offset, limit);

		if (!messages.isEmpty()) {
			setOffset(topicName, partitionNo, messages.get(messages.size() - 1).getOffset() + 1);
		}

		return messages;
	}

	private int getOffset(String topic, int partition)
	{
		return offsets
			.computeIfAbsent(topic, k -> new HashMap<>())
			.getOrDefault(partition, 0);
	}

	private void setOffset(String topic, int partition, int offset)
	{
		offsets.get(topic).put(partition, offset);
	}

}
