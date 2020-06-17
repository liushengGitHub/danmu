package liusheng.danmu.entity;

/**
 * 2020年:  05 月:  11 日:  17小时:  22分钟:
 * 用户名: 👨‍LiuSheng👨‍
 */

public class MusicInfo {

    /**
     * msg :
     * code : 0
     * data : {"songid":16978001,"songtype":"fc","squrl":"https://wsaudiobssdlbig.kugou.com/2005111707/UIlrijC-dzPRLKeh7VKyUA/1589274467/bss/extname/wsaudio/77c58fd1ac5283224a2d76ede9f7b914.mp3","squrlmd5":"77c58fd1ac5283224a2d76ede9f7b914","sqsize":"11847052","sqext":"mp3","hqurl":"https://wsaudiobssdlbig.kugou.com/2005111707/kOzzCHQ4G4PQ0M88S_C1kg/1589274467/bss/extname/wsaudio/df0130a86310f8c6b53aab06f310176a.mp3","hqurlmd5":"df0130a86310f8c6b53aab06f310176a","hqsize":"7108275","hqext":"mp3","lqurl":"https://wsaudiobssdlbig.kugou.com/2005111707/oYuYO-sfa2zlIhbmpiq8gg/1589274467/bss/extname/wsaudio/0d57cf573a1425eaacc12f5e93d86038.mp3","lqurlmd5":"0d57cf573a1425eaacc12f5e93d86038","lqsize":"4738865","lqext":"mp3","songName":"绿色","songKind":2,"user":{"ID":24789336,"NN":"Oamlna","I":"https://wsingbssdl.kugou.com/6506936db3d1b6c9924bf72b9b47e11c.jpg"},"DigitalAlbumID":0}
     * success : true
     * message : 成功
     */

    private String msg;
    private int code;
    private DataBean data;
    private boolean success;
    private String message;

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public static class DataBean {
        /**
         * songid : 16978001
         * songtype : fc
         * squrl : https://wsaudiobssdlbig.kugou.com/2005111707/UIlrijC-dzPRLKeh7VKyUA/1589274467/bss/extname/wsaudio/77c58fd1ac5283224a2d76ede9f7b914.mp3
         * squrlmd5 : 77c58fd1ac5283224a2d76ede9f7b914
         * sqsize : 11847052
         * sqext : mp3
         * hqurl : https://wsaudiobssdlbig.kugou.com/2005111707/kOzzCHQ4G4PQ0M88S_C1kg/1589274467/bss/extname/wsaudio/df0130a86310f8c6b53aab06f310176a.mp3
         * hqurlmd5 : df0130a86310f8c6b53aab06f310176a
         * hqsize : 7108275
         * hqext : mp3
         * lqurl : https://wsaudiobssdlbig.kugou.com/2005111707/oYuYO-sfa2zlIhbmpiq8gg/1589274467/bss/extname/wsaudio/0d57cf573a1425eaacc12f5e93d86038.mp3
         * lqurlmd5 : 0d57cf573a1425eaacc12f5e93d86038
         * lqsize : 4738865
         * lqext : mp3
         * songName : 绿色
         * songKind : 2
         * user : {"ID":24789336,"NN":"Oamlna","I":"https://wsingbssdl.kugou.com/6506936db3d1b6c9924bf72b9b47e11c.jpg"}
         * DigitalAlbumID : 0
         */

        private int songid;
        private String songtype;
        private String squrl;
        private String squrlmd5;
        private String sqsize;
        private String sqext;
        private String hqurl;
        private String hqurlmd5;
        private String hqsize;
        private String hqext;
        private String lqurl;
        private String lqurlmd5;
        private String lqsize;
        private String lqext;
        private String songName;
        private int songKind;
        private UserBean user;
        private int DigitalAlbumID;

        public int getSongid() {
            return songid;
        }

        public void setSongid(int songid) {
            this.songid = songid;
        }

        public String getSongtype() {
            return songtype;
        }

        public void setSongtype(String songtype) {
            this.songtype = songtype;
        }

        public String getSqurl() {
            return squrl;
        }

        public void setSqurl(String squrl) {
            this.squrl = squrl;
        }

        public String getSqurlmd5() {
            return squrlmd5;
        }

        public void setSqurlmd5(String squrlmd5) {
            this.squrlmd5 = squrlmd5;
        }

        public String getSqsize() {
            return sqsize;
        }

        public void setSqsize(String sqsize) {
            this.sqsize = sqsize;
        }

        public String getSqext() {
            return sqext;
        }

        public void setSqext(String sqext) {
            this.sqext = sqext;
        }

        public String getHqurl() {
            return hqurl;
        }

        public void setHqurl(String hqurl) {
            this.hqurl = hqurl;
        }

        public String getHqurlmd5() {
            return hqurlmd5;
        }

        public void setHqurlmd5(String hqurlmd5) {
            this.hqurlmd5 = hqurlmd5;
        }

        public String getHqsize() {
            return hqsize;
        }

        public void setHqsize(String hqsize) {
            this.hqsize = hqsize;
        }

        public String getHqext() {
            return hqext;
        }

        public void setHqext(String hqext) {
            this.hqext = hqext;
        }

        public String getLqurl() {
            return lqurl;
        }

        public void setLqurl(String lqurl) {
            this.lqurl = lqurl;
        }

        public String getLqurlmd5() {
            return lqurlmd5;
        }

        public void setLqurlmd5(String lqurlmd5) {
            this.lqurlmd5 = lqurlmd5;
        }

        public String getLqsize() {
            return lqsize;
        }

        public void setLqsize(String lqsize) {
            this.lqsize = lqsize;
        }

        public String getLqext() {
            return lqext;
        }

        public void setLqext(String lqext) {
            this.lqext = lqext;
        }

        public String getSongName() {
            return songName;
        }

        public void setSongName(String songName) {
            this.songName = songName;
        }

        public int getSongKind() {
            return songKind;
        }

        public void setSongKind(int songKind) {
            this.songKind = songKind;
        }

        public UserBean getUser() {
            return user;
        }

        public void setUser(UserBean user) {
            this.user = user;
        }

        public int getDigitalAlbumID() {
            return DigitalAlbumID;
        }

        public void setDigitalAlbumID(int DigitalAlbumID) {
            this.DigitalAlbumID = DigitalAlbumID;
        }

        public static class UserBean {
            /**
             * ID : 24789336
             * NN : Oamlna
             * I : https://wsingbssdl.kugou.com/6506936db3d1b6c9924bf72b9b47e11c.jpg
             */

            private int ID;
            private String NN;
            private String I;

            public int getID() {
                return ID;
            }

            public void setID(int ID) {
                this.ID = ID;
            }

            public String getNN() {
                return NN;
            }

            public void setNN(String NN) {
                this.NN = NN;
            }

            public String getI() {
                return I;
            }

            public void setI(String I) {
                this.I = I;
            }
        }
    }
}
