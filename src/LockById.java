import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantLock;

public class LockById {
    private static class LockWrapper{
        public final ReentrantLock lock=new ReentrantLock();
        private final AtomicInteger numberofThreadInqueue=new AtomicInteger(1);

        private LockWrapper addInqueue(String key)
        {
            numberofThreadInqueue.incrementAndGet();
            return this;

        }
        private int removefromqueue(String key)
        {
            return numberofThreadInqueue.decrementAndGet();
        }

    }
    private ConcurrentHashMap<String,LockWrapper> attainlockByIdMap=new ConcurrentHashMap<>();

    public void lock(String key)
    {
        LockWrapper lockWrapper=attainlockByIdMap.compute(key,(k,v)-> v==null ? new LockWrapper(): v.addInqueue(key));
        lockWrapper.lock.lock();
    }
    public void unlock(String key)
    {
        LockWrapper lockWrapper= attainlockByIdMap.get(key);
        lockWrapper.lock.unlock();
        if(lockWrapper.removefromqueue(key)==0)
        {
            attainlockByIdMap.remove(key,lockWrapper);
        }
    }
}
