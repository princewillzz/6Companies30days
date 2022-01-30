class Solution {

    public int findInMountainArray(int target, MountainArray mountainArr) {
        
        //find peak Index
        int len = mountainArr.length();
        int peakIndex = findPeakIndex(1,len-2,mountainArr);
        int index1 = findTarget(target,mountainArr,0,peakIndex,false);
        int index2 = findTarget(target,mountainArr,peakIndex,len-1,true);
        if(index1!=-1 && index2!=-1){
            return Math.min(index1,index2);
        }else{
            return Math.max(index1,index2);
        }
        
    }
    
    public int findTarget(int target, MountainArray mountainArr,int start, int end,boolean reverse){
        int index = -1;
        while(start<=end){
            int mid = start+(end-start)/2;
            int midVal = mountainArr.get(mid);
            if(midVal == target){
                index = mid;
                break;
            }else if(midVal<target){
                if(reverse){
                    end = mid-1;
                } 
                else{
                    start = mid+1;        
                }
                
            }else{
                if(reverse){
                    start = mid+1;
                }else{
                    end = mid-1;    
                }
                
            }
        }
        return index;
    }
    
    public int findPeakIndex(int start,int end, MountainArray mountainArr){
        int index = -1;
        while(start<=end){
            int mid = start+ (end-start)/2;
            int midVal = mountainArr.get(mid);
            int midleft = mountainArr.get(mid-1);
            int midright = mountainArr.get(mid+1);
            if(midVal>midleft && midVal>midright){
                index = mid;
                break;
            }else if(midVal < midleft){
                end = mid-1 ;
            }else if(midVal < midright){
                start = mid+1 ;
            }
        }
        return index;
    }
    }