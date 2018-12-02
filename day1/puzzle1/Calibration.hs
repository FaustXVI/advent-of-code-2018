module Calibration where

curate :: String -> String
curate s = map removePlus s
    where removePlus :: Char -> Char
          removePlus '+' = ' '
          removePlus c = c

calibrate :: (Monad m) => m String -> m Int
calibrate input = fmap read curatedInput
    where curatedInput = fmap curate input

main :: IO ()
main = fmap show (calibrate getContents) >>= putStrLn
