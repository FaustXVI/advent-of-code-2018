module Calibration where

curate :: String -> [String]
curate s = words $ map removePlus s
    where removePlus :: Char -> Char
          removePlus '+' = ' '
          removePlus c = c

sumNumbers :: [String] -> Int
sumNumbers = foldl (+) 0 . map read

calibrate :: (Monad m) => m String -> m Int
calibrate input = fmap (sumNumbers.curate) input 

main :: IO ()
main = fmap show (calibrate getContents) >>= putStrLn
