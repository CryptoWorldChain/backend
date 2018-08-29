package org.brewchain.backend.dbsync;

import onight.tfw.otransio.api.beans.FramePacket;

public interface CMDProc {

	public void onComplete(Daos dao,FramePacket pack);
	public void postRoute(Daos dao,FramePacket pack);
}
