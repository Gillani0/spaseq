package fr.uim.curien.cep.inter.face.beans;

public class QuadTimeFile implements StreamFiles{
	String streamId_;
	String filePath_;
	Long timeStamp_;
	
	public QuadTimeFile(String streamId, String filePath, Long timeStamp) {
		super();
		this.streamId_ = streamId;
		this.filePath_ = filePath;
		this.timeStamp_= timeStamp;

	}

	public String getStreamId_() {
		return streamId_;
	}

	public void setStreamId_(String streamId_) {
		this.streamId_ = streamId_;
	}
	@Override
	public String getFilePath_() {
		return filePath_;
	}

	public void setFilePath_(String filePath_) {
		this.filePath_ = filePath_;
	}

	public Long getTimeStamp_() {
		return timeStamp_;
	}

	public void setTimeStamp_(Long timeStamp_) {
		this.timeStamp_ = timeStamp_;
	}

	@Override
	public FileType getType() {
		// TODO Auto-generated method stub
		return FileType.QUADTIME;
	}

	

	@Override
	public int getGraphsize_() {
		// TODO Auto-generated method stub
		return 0;
	}
	
	
}
