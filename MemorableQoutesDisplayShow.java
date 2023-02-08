public class MemorableQoutesDisplayShow {
    MemorableQouteDatabase db = new MemorableQouteDatabase();
    int delayBetweenQoutes;
    int maxQoutesToDisplay;
    public MemorableQoutesDisplayShow(MemorableQouteDatabase db){
        this.db = db;
    }

    public void setDelayBetweenQoutes(int delay) {
        this.delayBetweenQoutes = delay;
    }
    public void setMaxQoutesToDisplay(int max) {
        this.maxQoutesToDisplay = max;
    }
    public int getDelayBetweenQoutes() {
        return this.delayBetweenQoutes;
    }

    public int getMaxQoutesToDisplay(){
        return this.maxQoutesToDisplay;
    }

    public void execute(int maxQoutes, int delay) {
        if(maxQoutes <= 0) {
            while(true) {
                MemorableQoute q = MemorableQoute.getRandomQuote(db.getSize(), db);
                MemorableQoute.printQoute(q.getQoute(), q.getPrintCounter());
                try {
                    Thread.sleep(delay*1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
        else {
            for(int i = 0; i < maxQoutes; i++) {
                MemorableQoute q = MemorableQoute.getRandomQuote(db.getSize(), db);
                String randQoute = q.getQoute();
                MemorableQoute.printQoute(q.getQoute(), q.getPrintCounter());
                try {
                    Thread.sleep(delay*1000);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }
        }
    }

    
}
