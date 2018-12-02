module Calibration where

curate :: String -> [String]
curate s = words $ map removePlus s
    where removePlus :: Char -> Char
          removePlus '+' = ' '
          removePlus c = c

firstDuplicate :: [Int] -> Int
firstDuplicate = firstDuplicate' []
    where firstDuplicate' p (x:xs) = if x `elem` p then x else firstDuplicate' (x:p) xs

sumNumbers :: [String] -> Int
sumNumbers s = firstDuplicate $ scanl (+) 0 $ cycle numbers
    where numbers = map read s

calibrate :: (Monad m) => m String -> m Int
calibrate input = fmap (sumNumbers.curate) input 

main :: IO ()
main = fmap show (calibrate getContents) >>= putStrLn
