package smtx_handler;

import java.util.Comparator;

public class BlockComparator implements Comparator<Block> {

	
	/**
	 * overridden compareTo(Object o)
	 * 
	 * @return 		< 0 if this is smaller, 0 if equal, > 0 if this is greater.
	 * 				this is equivalent for the current object
	 */
	public int compare(Block self, Block comparedWith) {
		Long currentOffset = Long.parseLong(self.getBlockOffset());
		Long otherBlock = Long.parseLong(comparedWith.getBlockOffset());
		
		return ((int) (currentOffset - otherBlock));
	}
}
