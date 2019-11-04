package hr.fer.prvazadcaklijent.tcp;

public interface Server {
		public void startup();

		public void loop();

		public void shutdown();

		public boolean getRunningFlag();
}
