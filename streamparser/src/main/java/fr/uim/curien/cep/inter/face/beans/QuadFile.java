package fr.uim.curien.cep.inter.face.beans;

public class QuadFile implements StreamFiles {
	private final String streamId_;
	private final String filePath_;
	
	public QuadFile(String streamId, String filePath) {
		super();
		this.streamId_ = streamId;
		this.filePath_ = filePath;
	}
	public String getStreamId_() {
		return streamId_;
	}

	@Override
	public String getFilePath_() {
		return filePath_;
	}

	@Override
	public String toString() {
		return "StreamFiles [streamId_=" + streamId_ + ", filePath_=" + filePath_ + "]";
	}
	@Override
	public FileType getType() {
		// TODO Auto-generated method stub
		return FileType.QUAD;
	}
	@Override
	public  int getGraphsize_() {
		// TODO Auto-generated method stub
		return 0;
	}
}
