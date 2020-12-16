class Solution:
    # A string S of lowercase English letters is given. 
    # We want to partition this string into as many parts as possible so that each letter appears in at 
    # most one part, and return a list of integers representing the size of these parts.
    def partitionLabels(self, S: str) -> List[int]:
        freq_map = {}
        for i in range(len(S)):
            freq_map[S[i]] = i
        
        print(freq_map)
        end = 0
        partition = []
        count = 0
        
        for k in range(len(S)):
            current = S[k]
            if k > end:
                partition.append(count)
                end = freq_map[current]
                count = 1
                continue
            end = max(end, freq_map[current])
            count += 1
        partition.append(count)
        print(partition)
        return partition
    
# another possible solution is to find intervals of all letters and merge them into partitions 
# but too lazy to code that :D