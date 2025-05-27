package pubsub;


import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Topic
{
	private final String name;
	private final List<Partition> partitions;

	public Topic(String name, int partitions)
	{
		this.name = name;
		this.partitions = new ArrayList<>();
		for (int i = 0; i < partitions; i++)
		{
			this.partitions.add(new Partition());
		}
	}

	public void publish(String data)
	{
		int partitionIndex = data.hashCode() % partitions.size();
		if (partitionIndex < 0)
		{
			partitionIndex += partitions.size(); // Ensure non-negative index
		}
		partitions.get(partitionIndex).addMessage(data);
	}

	public Partition getPartition(int index)
	{
		if (index < 0 || index >= partitions.size())
		{
			throw new IndexOutOfBoundsException("Partition index out of bounds: " + index);
		}
		return partitions.get(index);
	}
}
