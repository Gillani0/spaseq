package fr.ujm.curien.cep.inter.face.manager;

import java.util.concurrent.BlockingQueue;

import edu.telecomst.graph.processing.GraphEvent;

public class EventGraphConsumer implements Runnable {

	private BlockingQueue<GraphEvent> queue;

	public EventGraphConsumer(BlockingQueue<GraphEvent> queue) {
		super();
		this.queue = queue;
	}

	@Override
	public void run() {
		int i = 0;
		// TODO Auto-generated method stub
		for (;;) {
			try {
				final GraphEvent take = queue.take();
				++i;
				if (take.getId() != -1) {
					
					if(take.getMapped()==null){
						System.out.println("k "+ take.getTimeStamp());
					}
					
					System.out.println("recived ok " + take.getMapped().length +"  "+ i+" " +take.getTimeStamp());
				} else {
					break;
				}
			} catch (final Exception e) {
				e.printStackTrace();
			}
		}
	}

}
