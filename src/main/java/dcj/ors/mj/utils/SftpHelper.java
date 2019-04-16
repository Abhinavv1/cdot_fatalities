package dcj.ors.mj.utils;

import org.mule.api.MuleEventContext;
import org.mule.api.transport.PropertyScope;

import com.jcraft.jsch.Channel;
import com.jcraft.jsch.ChannelSftp;
import com.jcraft.jsch.JSch;
import com.jcraft.jsch.JSchException;
import com.jcraft.jsch.Session;

public class SftpHelper implements org.mule.api.lifecycle.Callable {

	private final static String SFTP = "sftp";

	private final static String STRICT_HOST_KEY_CHECKING = "StrictHostKeyChecking";

	public static ChannelSftp createChannel(Session session) {
		ChannelSftp command = null;

		try {
			Channel channel = session.openChannel(SFTP);
			channel.connect();
			command = (ChannelSftp) channel;
		} catch (JSchException e) {
			releaseConnection(session, null);
			// throw new SftpLiteException("Error opening SFTP channel. Original
			// Cause("+e.getMessage()+")");
			System.out.println(e.getMessage());
			
		}
		return command;

	}

	public static void releaseConnection(Session session, ChannelSftp command) {
		if (command != null)
			command.exit();
		if (session != null)
			session.disconnect();
	}


	@Override
	public Object onCall(MuleEventContext eventContext) throws Exception {

		String port = eventContext.getMessage().getProperty("port", PropertyScope.INVOCATION);
		//System.out.println(port);
		String fileName = eventContext.getMessage().getProperty("fileName", PropertyScope.INVOCATION);
		//System.out.println(fileName);

		String path = eventContext.getMessage().getProperty("path", PropertyScope.INVOCATION);
		//System.out.println(path);
		
		String username = eventContext.getMessage().getProperty("username", PropertyScope.INVOCATION);
		//System.out.println(username);
		
		String host = eventContext.getMessage().getProperty("host", PropertyScope.INVOCATION);
		//System.out.println(host);
		
		String password = eventContext.getMessage().getProperty("password", PropertyScope.INVOCATION);
		//System.out.println(password);


		this.removeFileFromSFTPServer(fileName, path, username, password, port, host);
		return eventContext.getMessage().getPayload();
	}

	public void removeFileFromSFTPServer(String filename, String path, String username, String password, String port,
			String host) {
		JSch ssh = new JSch();
		Session session = null;

		try {
			session = ssh.getSession(username, host, Integer.parseInt(port));
			session.setPassword(password);
			java.util.Properties config = new java.util.Properties();
			config.put(STRICT_HOST_KEY_CHECKING, "no");
			session.setConfig(config);
			session.connect();
			ChannelSftp command = createChannel(session);
			//System.out.println(path + "/" + filename);
			command.rm(path + "/" + filename);
			releaseConnection(session, null);
		} catch (Exception e) {
			System.out.println(e.getMessage());
			if (session == null) {
				System.out.println(e.getMessage());
				// throw new Exception("Error creating SFTP session. Original
				// Cause);
			}
		}
	}

}

