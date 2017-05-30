package fr.uim.curien.cep.inter.face.beans;

public class TripleFile implements StreamFiles {
	private final String streamId_;
	private final String filePath_;
	private final int graphsize_;
	private  long id= -1;
	
	
	public TripleFile(String streamId, String filePath, int graphsize) {
		super();
		this.streamId_ = streamId;
		this.filePath_ = filePath;	
		this.graphsize_ = graphsize;

	}

	public String getStreamId_() {
		return streamId_;
	}

	public String getFilePath_() {
		return filePath_;
	}
	

	/**
	 * @return the id
	 */
	public long getId() {
		return id;
	}

	/**
	 * @param id the id to set
	 */
	public void setId(long id) {
		this.id = id;
	}

	@Override
	public int getGraphsize_() {
		return graphsize_;
	}

	@Override
	public String toString() {
		return "StreamFiles [streamId_=" + streamId_ + ", filePath_=" + filePath_ + ", graphsize_=" + graphsize_ + "]";
	}

	@Override
	public FileType getType() {
		// TODO Auto-generated method stub
		return FileType.TRIPLE;
	}

}
