package org.brewchain.backend.dbsync;

import java.util.HashMap;

import org.apache.felix.ipojo.annotations.Provides;
import org.fc.zippo.filter.FilterConfig;
import org.fc.zippo.filter.exception.FilterException;

import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import onight.osgi.annotation.iPojoBean;
import onight.tfw.async.CompleteHandler;
import onight.tfw.ntrans.api.ActWrapper;
import onight.tfw.ntrans.api.ActorService;
import onight.tfw.ntrans.api.annotation.ActorRequire;
import onight.tfw.otransio.api.PacketFilter;
import onight.tfw.otransio.api.SimplePacketFilter;
import onight.tfw.otransio.api.beans.FramePacket;

@iPojoBean
@Slf4j
@Provides(specifications = { PacketFilter.class, ActorService.class }, strategy = "SINGLETON")
@Data
public class BCPacketFilter extends SimplePacketFilter implements ActorService {

	@Override
	public String getSimpleName() {
		return "BCPacketFilter";
	}

	@ActorRequire(name = "dbsync.daos")
	Daos daos;

	@Override
	public String[] modules() {
		return new String[] { "DOB" };
	}

	String defaultCharset = "utf-8";
	HashMap<String, CMDProc> procMap = new HashMap<>();

	public void init(FilterConfig filterConfig) throws FilterException {
		defaultCharset = filterConfig.getStrProp("org.zippo.rest.charset", "utf-8");

		procMap.put("MIN", new ProcDOB());

		log.debug("init BCPacketFilterOK:dao=" + daos + ",procs=" + procMap);
	}

	@Override
	public boolean preRoute(ActWrapper arg0, FramePacket pack, CompleteHandler arg2) throws FilterException {
		log.debug("preRoute for GCMD=" + pack.getCMD());
		return true;
	}

	
	@Override
	public boolean postRoute(ActWrapper actor, FramePacket pack, CompleteHandler handler) throws FilterException {
		log.debug("postRouter for GCMD=" + pack.getCMD());
		if (pack.getFbody() != null) {
			CMDProc proc = procMap.get(pack.getCMD());
			if (proc != null) {
				proc.postRoute(daos, pack);
			}
		}
		return true;
	}

	@Override
	public boolean onComplete(ActWrapper actor, FramePacket completepack) throws FilterException {
		log.debug("onComplete for GCMD=" + completepack.getCMD());
		if (completepack.getFbody() != null) {
			CMDProc proc = procMap.get(completepack.getCMD());
			if (proc != null) {
				proc.onComplete(daos, completepack);
			}
		}
		return true;
	}

}
